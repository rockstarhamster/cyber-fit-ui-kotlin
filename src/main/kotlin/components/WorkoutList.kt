package components

import csstype.Display
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.p
import react.router.dom.Link
import react.useState
import kotlin.js.Date

external interface WorkoutListProps : Props {
    var workouts: List<Workout>
}

val WorkoutList = FC<WorkoutListProps> { props ->
    var addingNewOne: Boolean by useState(false)

    for (workout in props.workouts) {
        div {
            p {
                +"${workout.date} ${workout.title}"
            }
            ExerciseList {
                exercises = workout.exercises
            }
        }
    }
    if (addingNewOne) {
        p {
            +"Adding logic should be there"
        }
    }
    button {
        css {
            display = Display.block
        }
        onClick = {
            addingNewOne = !addingNewOne
        }
        +"Add new workout"
    }
}

data class Workout(
    val date: Date,
    val title: String,
    val exercises: List<Exercise>
)