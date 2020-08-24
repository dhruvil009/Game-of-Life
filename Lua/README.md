# Game-of-Life
The implementation for Conway's Game of Life in Lua

# Running LUA on LINUX 
$ wget http://www.lua.org/ftp/lua-5.2.3.tar.gz

$ tar zxf lua-5.2.3.tar.gz

$ cd lua-5.2.3

$ make linux test


# Running LUA on MAC OS X
$ curl -R -O http://www.lua.org/ftp/lua-5.2.3.tar.gz

$ tar zxf lua-5.2.3.tar.gz

$ cd lua-5.2.3

$ make macosx test


# Testing if LUA is intalled or not
Save the following code in the file name - helloWorld.lua

print("Hello World!) -- comment using "--"


Run as follows on terminal - 

$ lua helloWorld

# Running Lua using Visual Studio Code
* Open a folder in a workspace in VSCode

* In that folder, create a sample Lua file - can make the same helloWorld.lua file from previous steps.

* Create a file named "tasks.json" in the same folder and paste the following content - 

```
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Run Lua",
      "type": "shell",
      "command": "lua53",
      "args": [
        "${file}"
      ],
      "group": {
        "kind": "build",
        "isDefault": true
      }
    }
  ]
}

```
* Open the helloWorld.lua file and run ctrl+shift+B from your keyboard or go to terminal from menu bar on the top of VSCode and Run build task.
* You should see the output in VSCode terminal.




