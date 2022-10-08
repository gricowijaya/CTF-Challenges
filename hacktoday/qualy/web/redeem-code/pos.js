(function() {                if (window.scriptExecuted1661652274658) {                    return;                }                var script = document.createElement("script");                script.setAttribute("type", "text/javascript");                script.textContent = "\n\
            (function () {\n\
                try {\n\
                    \n\
                } catch (ex) {\n\
                    console.error(\'Error executing js: \' + ex);\n\
                }\n\
            })();\n\
            ";                var FRAME_REQUESTS_LIMIT = 500;                var frameRequests = 0;                function waitParent () {                    frameRequests += 1;                    var parent = document.head || document.documentElement;                    if (parent) {                        try {                            parent.appendChild(script);                            parent.removeChild(script);                        } catch (e) {                        } finally {                            window.scriptExecuted1661652274658 = true;                            return true;                        }                    }                    if(frameRequests < FRAME_REQUESTS_LIMIT) {                        requestAnimationFrame(waitParent);                    } 
                }                waitParent();            })()
