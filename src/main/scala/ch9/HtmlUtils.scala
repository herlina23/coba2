package ch9

object HtmlUtils {
  def removeMarkup(input: String) = {
    input
      .replaceAll("(?s)<script.*</script>", "")
      .replaceAll("""</?\w[^>]*>""","")
      .replaceAll("<.*>","")
  }
}