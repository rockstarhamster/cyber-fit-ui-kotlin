package components

import csstype.Color
import csstype.Cursor
import csstype.Display
import csstype.Length.Companion.auto
import csstype.LineStyle
import csstype.NamedColor
import csstype.Overflow
import csstype.TextAlign
import csstype.pct
import csstype.px
import csstype.s
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.ul
import react.router.dom.Link
import react.useState

external interface AthleteAccordionProps : Props {
    var athlete: Athlete
}

val AthleteAccordion = FC<AthleteAccordionProps> { props ->
    var opened: Boolean by useState(false)

    button {
        css {
            hover {
                backgroundColor = Color("#ccc")
            }
            backgroundColor = if (opened) Color("#ccc") else Color("#eee")
            color = Color("#444")
            cursor = Cursor.pointer
            padding = 18.px
            width = 100.pct
            textAlign = TextAlign.left
            transition = 0.4.s
            border = LineStyle.none
            outline = LineStyle.none
        }
        onClick = {
            opened = !opened
        }
        +props.athlete.name
    }
    div {
        css {
            display = if (opened) Display.block else Display.none
            overflow = Overflow.hidden
        }
        button {
            css {
                backgroundColor = NamedColor.green
                marginLeft =  auto
                marginRight = 0.px
            }
            Link {
                css {
                    color = NamedColor.white
                }
                to = "athletes/${props.athlete.id}/workouts/new"
                +"New"
            }
        }
        for (workout in props.athlete.workouts) {
            ul {
                li {
                    +"${workout.date.getDay()}-${workout.date.getMonth()}-${workout.date.getFullYear()} ${workout.title}"
                }
            }
        }
    }
}