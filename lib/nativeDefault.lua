-- Default native library 
local native = require("native") -- native integration

function java_io_PrintStream__print(class, method, args)
	io.stdout:write(native.stringToLua(args[2]))
end