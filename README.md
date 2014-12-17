WebControl
=======
WebControl opens up a RESTful API which will securely allow server owners and developers to write web, mobile, and desktop applications which can execute commands, get information from, and control the Sponge server through a web API. Here's an example.

    POST /wc/chat/broadcast HTTP/1.1
    Content-Type: application/json
    Content-Length: ...
    
    {"_key": "dcc9476d5b901f788357ad0dd09801e4c01dd13fc887fdfdc528d53770a5187b",
     "_username": "helloworld",
     "data": {"text": "Hello, world!"}
    }
----------
    HTTP/1.1 200 OK
    Content-Type: application/json
    Content-Length: ...
    
    {"success": true}

Through WebControl's API, you can do things like send chat messages, send private messages, teleport players, spawn mobs, interact with the world, get data about the world and players -- basically anything Sponge's API will allow you to do.


Security
-----
WebControl provides facilities that allow you to restrict certain methods and actions to certain accounts. Through a Permissions-like system, "accounts" can be created which let you set permissions - if you ever need to expose data to, for example, a JavaScript client where the username and password are easily readable, you can set that client's account to only be able to do one thing or execute one method on the server. WebControl's security is based around these accounts and "keys", or SHA-256 hashes of the method name, username, and password, which guarantee that the request is coming from a legit source. In the future, WebControl will provide an API for other Sponge plugin developers to add methods and data sources that can be used through WebControl.

Security is still a bit up in the air right now, and these details ~~may~~ **will** change before initial release. 

Download
-----
Nothing yet... but if you want, you can watch and participate in development on my GitHub: https://github.com/tman0/webcontrol/
Preliminary documentation is here: http://docs.webcontrol1.apiary.io/ - please let me know in the forum what you think or any ideas to improve the API, nothing is set in stone yet.
