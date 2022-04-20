package components

import csstype.FontDisplay
import csstype.LengthType
import csstype.Margin
import csstype.pct
import react.FC
import react.Props
import react.css.css
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div

external interface AthleteListProps : Props {
    var athletes: List<Athlete>
}

val AthleteList = FC<AthleteListProps> { props ->
    div {
        css {
            width = 50.pct
            margin = Margin("auto")
        }
        for (athlete in props.athletes) {
            AthleteAccordion {
                this.athlete = athlete
            }
        }
    }
}

data class Athlete(
    val id: String,
    val name: String,
    val workouts: List<Workout>
)