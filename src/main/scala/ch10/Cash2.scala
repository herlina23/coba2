//package ch10
//
//object SyntheticCodes {
//  // Synthetic Code for a CashProduct
//  object Cash extends (CashProduct => String) {
//    def apply(p: CashProduct) = p.currency.name + "="
//
//    //EXTRACTOR
//    def unapply(s: String)(implicit ps: ProductService): Option[CashProduct] = {
//      if (s.endsWith("=")
//        Some(ps.findCash(s.substring(0,3)))
//      else None
//    }
//  }
//  //Synthetic Code for a ForwardProduct
//  object Forward extends (ForwardProduct => String) {
//    def apply(p: ForwardProduct) = p.currency.name + p.date.toString + ".FWD"
//
//    //EXTRACTOR
//    def unapply(s: String)(implicit ps: ProductService): Option[ForwardProduct] = {
//      if (s.endsWith(".FWD")
//        Some(ps.findForward(s.substring(0,3), s.substring(3, 9))
//      else None
//    }
//  }
//
//  class CashProduct {
//    def getCode = SyntheticCodes.Cash(this)
//  }
//
//  class ForwardProduct {
//    def getCode = SyntheticCodes.Forward(this)
//  }
//
//
//
// // * trait Seq[+A] extends PartialFunction[Int, A] *
//
//  //Hmm, why does Seq extend PartialFunction[Int, A] (which in turns inherits Function1[A, B]? Because if we think about it, if I pass a List[A] an Int, representing the index of the element I'm seeking, it will (not efficiently) return me the element at that given index (if present).