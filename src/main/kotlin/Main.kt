import kotlinx.browser.document
import react.dom.render
import react.redux.provider
import reducers.State
import reducers.rootReducer
import redux.createStore
import redux.rEnhancer

val store = createStore(::rootReducer, State(), rEnhancer())

fun main() {
    val container = document.getElementById("root")!!
    render(container) {
        provider(store) {
            app()
        }
    }
}


