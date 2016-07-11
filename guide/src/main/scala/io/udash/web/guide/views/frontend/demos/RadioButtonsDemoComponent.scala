package io.udash.web.guide.views.frontend.demos

import io.udash._
import io.udash.bootstrap.{BootstrapStyles, BootstrapTags}
import io.udash.web.guide.styles.partials.GuideStyles
import org.scalajs.dom.Element
import org.scalajs.dom.html.Input

import scalatags.JsDom

class RadioButtonsDemoComponent extends Component {
  import io.udash.web.guide.Context._

  import JsDom.all._
  import scalacss.ScalatagsCss._

  sealed trait Fruit
  case object Apple extends Fruit
  case object Orange extends Fruit
  case object Banana extends Fruit

  val favoriteFruit: Property[Fruit] = Property[Fruit](Apple)
  val favoriteFruitString = favoriteFruit.transform(
    (f: Fruit) => f.toString,
    (s: String) => s match {
      case "Apple" => Apple
      case "Orange" => Orange
      case "Banana" => Banana
    }
  )

  override def getTemplate: Element = div(id := "radio-buttons-demo", GuideStyles.get.frame)(
    form(BootstrapStyles.containerFluid)(
      div(BootstrapStyles.row)(
        div(
          checkboxes()
        ),
        br(),
        div(
          checkboxes()
        )
      )
    )
  ).render

  def checkboxes() = div(BootstrapStyles.Form.inputGroup, GuideStyles.get.blockOnMobile)(
    div(BootstrapStyles.Form.inputGroupAddon, GuideStyles.get.blockOnMobile)("Fruits:"),
    div(BootstrapStyles.Form.inputGroupAddon, GuideStyles.get.blockOnMobile)(
      RadioButtons(
        favoriteFruitString, Seq(Apple, Orange, Banana).map(_.toString),
        (els: Seq[(Input, String)]) => span(els.map { case (i: Input, l: String) => label(BootstrapStyles.Form.radioInline, BootstrapTags.dataLabel := l)(i, l) })
      )
    ),
    div(BootstrapStyles.Form.inputGroupAddon, GuideStyles.get.blockOnMobile)(span(cls := "radio-buttons-demo-fruits")(bind(favoriteFruit)))
  )
}
