console.log('to-inject-isolated-way.js is loaded');

function helloIsolate() {
    alert("helloIsolate! You can't call me directly");
}

helloIsolate();

let script = document.createElement("script");
script.src = chrome.extension.getURL("target-functions.js")
let base = document.head || document.documentElement
base.appendChild(script)