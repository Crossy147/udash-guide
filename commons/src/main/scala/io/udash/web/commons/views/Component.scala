package io.udash.web.commons.views

import org.scalajs.dom
import org.scalajs.dom._

import scalatags.generic.Modifier

trait Component extends Modifier[dom.Element] {
  def getTemplate: Modifier[dom.Element]

  def apply(): Modifier[dom.Element] = getTemplate

  override def applyTo(t: Element): Unit =
    getTemplate.applyTo(t)
}