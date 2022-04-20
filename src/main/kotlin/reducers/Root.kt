package reducers

import actions.IncrementCount
import redux.RAction

data class State(
    var count: Int = 0
)

fun rootReducer(state: State, action: Any) = when(action.unsafeCast<RAction>()) {
    is IncrementCount -> state.copy(count = state.count + 1).also { console.log(it) }
    else -> state
}