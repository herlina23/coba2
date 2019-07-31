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