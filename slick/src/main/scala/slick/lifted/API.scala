package slick
package lifted

import slick.ast.{TypedType, ScalaBaseType}

import scala.language.higherKinds
import scala.language.implicitConversions

object API {
  implicit def booleanColumnType = ScalaBaseType.booleanType
  implicit def bigDecimalColumnType = ScalaBaseType.bigDecimalType
  implicit def byteColumnType = ScalaBaseType.byteType
  implicit def charColumnType = ScalaBaseType.charType
  implicit def doubleColumnType = ScalaBaseType.doubleType
  implicit def floatColumnType = ScalaBaseType.floatType
  implicit def intColumnType = ScalaBaseType.intType
  implicit def longColumnType = ScalaBaseType.longType
  implicit def shortColumnType = ScalaBaseType.shortType
  implicit def stringColumnType = ScalaBaseType.stringType

  implicit final def anyToShapedValue[T, U](value: T)(implicit shape: Shape[_ <: FlatShapeLevel, T, U, _]): ShapedValue[T, U] =
    new ShapedValue[T, U](value, shape)

  implicit def valueToConstColumn[T : TypedType](v: T): LiteralColumn[T] = new LiteralColumn[T](v)
}