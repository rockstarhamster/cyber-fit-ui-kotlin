import actions.IncrementCount
import csstype.WillChange
import react.ComponentClass
import react.FC
import react.Props
import react.RBuilder
import react.RComponent
import react.createElement
import react.dom.html.ReactHTML.button
import react.invoke
import react.redux.rConnect
import react.router.Route
import react.router.Routes
import react.router.dom.BrowserRouter
import reducers.State
import redux.RAction

external interface AppProps : Props {
    var count: Int
    var clickCountButton: () -> Unit
}

fun RBuilder.app() = BrowserRouter {
    Routes {
        Route {
            attrs.index = true
            attrs.element = createElement {
                countButton()
            }
        }
/*        Route {
            path = "athletes/:id/workouts/new"
            element = WorkoutAdditionPage.create()
        }*/
    }
}

fun RBuilder.countButton() {
    countButton {}
}
/*    val testExercises1 = listOf(
        Exercise(1, "Бицепс стоя", 5, 5),
        Exercise(3, "Бицепс лёжа", 3, 20),
        Exercise(2, "Бицепс сидя", 5, 3),
        Exercise(4, "Бицепс хуицепс", 6, 12),
    )
    val testExercises2 = listOf(
        Exercise(2, "Пресс сидя", 5, 3),
        Exercise(4, "Пресс хуесс", 6, 12),
        Exercise(3, "Пресс лёжа", 3, 20),
        Exercise(1, "Пресс стоя", 5, 5),
    )
    val testWorkouts = listOf(
        Workout(Date(), "День бицухи", testExercises1),
        Workout(Date(), "День пресса", testExercises2)
    )
    val athletes = listOf(
        Athlete("1","Лёха Мидиницин", testWorkouts),
        Athlete("2", "Яся Мидиницина", testWorkouts),
        Athlete("3", "Санчо Панчо", testWorkouts)
    )

    BrowserRouter {
        Routes {
            Route {
                path = "athletes/:id/workouts/new"
                element = WorkoutAdditionPage.create()
            }
            Route {
                index = true
                element = AthleteList.create {
                    this.athletes = athletes
                }
            }
        }
    }*/

private external interface AppStateProps : Props {
    var count: Int
}

private external interface AppDispatchProps : Props {
    var clickCountButton: () -> Unit
}

val countButton: ComponentClass<Props> =
    rConnect<State, RAction, WillChange, Props, AppStateProps, AppDispatchProps, AppProps>(
        { state, _ ->
            count = state.count
        },
        { dispatch, _ ->
            clickCountButton = { dispatch(IncrementCount()) }
        }
    )(RedButton::class.js.unsafeCast<ComponentClass<AppProps>>())

@JsExport
class RedButton(props: AppProps): RComponent<AppProps, react.State>(props) {
    override fun RBuilder.render() {
        button {
            attrs.onClick = {
                props.clickCountButton()
            }
            +"${props.count}"
        }
    }
}


