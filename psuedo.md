# Main
```
input rom file
load rom file
process rom file
new D5700
flash D5700 rom
D5700.run()
```

# CPU Construct
```
new registerBank
new parser(registerBank)
new executive(parser)
```

# CPU.start()
```
executive.start()
```

# Executive.start()
```
pc = [0,0]
timer = 0
clock = new Executor
clock, every 2ms run main loop
```

# Executive main loop
```
set ROM mode
read ROM at pc
restore ROM mode
nibble instruction
instruction = parser.parse()
instruction.run()
```

# Instructions
## Store
```
mainFunction(nibbles)
    take nibble 1 as whole byte
    registerBank.write(nibble 0, stitched)
```
## Add
```
mainFunction(nibbles)
    read nibble 1 from bank
    read nibble 2 from bank
    add those together
    store in nibble 3 in bank
```
## Subtract
```
mainFunction(nibbles)
    read nibble 1 from bank
    read nibble 2 from bank
    subtract 2 from 1
    store in nibble 3 in bank
```
## Read
```
mainFunction(nibbles)
    read address from bank
    read from memory at address
    store in bank at nibble 1
```
## Write
```
mainFunction(nibbles)
    read address from bank
    read bank at nibble 1
    write that to memory at address
```
## Jump
```
newPc
mainFunction(nibbles)
    newPc = stitch nibbles 1-3 together
    error if newPc %2 != 0
handleCounter(pc)
    return newPc
```
## Read Keyboard
```
mainFunction(nibbles)
    D5700.readKeyboard()
    store value into nibble 1
```
## Switch Memory
```
mainFunction(nibbles)
    D5700.memory.switch()
```
## Skip Equal
```
amount = 0
mainFunction(nibbles)
    read nibble 1 from bank
    read nibble 2 from bank
    if equal: amount = 4
    else: amount = 2
handleCounter(pc)
    return pc + amount
```
## Skip Not Equal
```
amount = 0
mainFunction(nibbles)
    read nibble 1 from bank
    read nibble 2 from bank
    if equal: amount = 2
    else: amount = 4
handleCounter(pc)
    return pc + amount
```
## Set A
```
mainFunction(nibbles)
    a = stitch nibbles 1-3 together
    write a to bank
```
## Set T
```
mainFunction(nibbles)
    stitch nibble 1 and 2 together
    set t to be that
```
## Read T
```
mainFunction(nibbles)
    get t from bank
    set nibble 1 in bank to be t
```
## Convert Base 10
```
mainFunction(nibbles)
    read nibble 1 from bank
    convert to base 10
    store 100s in a
    store 10s in a + 1
    store 1s in a + 2
```
## Convert ASCII
```
mainFunction(nibbles)
    read nibble 1 from bank
    error if greater than 0x0F
    convert to ascii
    store in nibble 2
```
## Draw
```
mainFunction(nibbles)
    read nibble 1 as value
    error if greater than 0x7F
    read nibble 2 as row
    read nibble 3 as col
    D5700.drawScreen(value, row, col)    
```
