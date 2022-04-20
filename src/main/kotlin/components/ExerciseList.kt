package components

import react.FC
import react.Props
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol

external interface ExerciseListProps : Props {
    var exercises: List<Exercise>
}

val ExerciseList = FC<ExerciseListProps> { props ->
    ol {
        val orderedExercises = props.exercises.sortedBy { it.order }
        for(exercise in orderedExercises) {
            li {
                +"${exercise.name} ${exercise.steps}X${exercise.reps}"
            }
        }
    }
}

data class Exercise(
    val order: Int,
    val name: String,
    val steps: Int,
    val reps: Int
)