package io.udash.web.homepage.components

import io.udash.web.homepage.styles.partials.ButtonsStyle

import scalatags.JsDom.all._
import scalacss.ScalatagsCss._

/**
  * Created by malchik on 2016-04-04.
  */
object Buttons {
  def whiteBorderButton(link: String, label: String, xs: Modifier*) =
    a(href := link, target := "_blank", ButtonsStyle.get.btnDefault, xs: Modifier)(
      div(ButtonsStyle.get.btnDefaultInner)(label)
    )

  def blackBorderButton(link: String, label: String, xs: Modifier*) =
    a(href := link, target := "_blank", ButtonsStyle.get.btnDefault, ButtonsStyle.get.btnDefaultBlack, xs: Modifier)(
      div(ButtonsStyle.get.btnDefaultInner, ButtonsStyle.get.btnDefaultInnerBlack)(label)
    )
}
