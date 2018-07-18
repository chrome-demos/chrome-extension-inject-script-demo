package example

import chrome.tabs.InjectDetails
import chrome.tabs.QueryInfo
import chrome.tabs.Tab
import kotlinjs.common.JsObj

fun main(args: Array<String>) {
    val file = "to-inject-isolated-way.js"
    currentTab { tab ->
        chrome.tabs.executeScript(tab.id!!, JsObj<InjectDetails>().apply {
            this.file = file
        }) { result ->
            console.log("Injected $file, result: $result")
        }
    }
}

private fun currentTab(fn: (Tab) -> Unit) {
    chrome.tabs.query(JsObj<QueryInfo>().apply {
        this.active = true
    }) { tabs ->
        tabs.firstOrNull()?.run { fn(this) }
    }
}