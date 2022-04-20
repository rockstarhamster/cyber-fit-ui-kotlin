package components

import csstype.Length.Companion.auto
import csstype.NamedColor
import csstype.pct
import kotlinx.browser.document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.asList
import react.FC
import react.Props
import react.css.css
import react.dom.html.InputType
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.input
import react.dom.html.ReactHTML.label
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ol
import react.useState

private val exerciseListId = "exerciseList"

val WorkoutAddition = FC<Props> {
    var exerciseCount: Int by useState(1)

    div {
        css {
            width = 50.pct
            margin = auto
        }
        label {
            +"Название"
        }
        label {
            +"Подходы"
        }
        label {
            +"Повторения"
        }
        ol {
            id = exerciseListId
            for (i in 1..exerciseCount) {
                li {
                    input {
                        type = InputType.text
                    }
                    input {
                        type = InputType.number
                    }
                    input {
                        type = InputType.number
                    }
                    button {
                        onClick = {
                            exerciseCount--
                        }
                        css {
                            backgroundColor = NamedColor.red
                            color = NamedColor.white
                        }
                        +"Delete"
                    }
                }
            }
        }
        button {
            onClick = {
                exerciseCount++
            }
            css {
                backgroundColor = NamedColor.green
                color = NamedColor.white
            }
            +"Add"
        }
        button {
            css {
                backgroundColor = NamedColor.green
                color = NamedColor.white
            }
            onClick = {
                saveWorkout()
            }
            +"Save"
        }
    }
}

private fun saveWorkout() {
    val exerciseList = document.getElementById(exerciseListId)?.getElementsByTagName("li")?.asList()
        ?.flatMap {
            it.getElementsByTagName("input").asList()
        }
        ?.forEach {
            it as HTMLInputElement
            console.log(it.value)
        }
}