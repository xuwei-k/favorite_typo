package favorite_typo

import twitter4j.Status

object Main {

  def main(args: Array[String]): Unit = {
    val config = Eval.fromFileName[Config]("config.scala")

    val twitter = config.getTwitter
    val stream = config.getTwitterStream
    stream.addListener(new twitter4j.StatusAdapter {
      override def onStatus(status: Status): Unit = {
        val text = status.getText
        if(config.typoWords.exists(typo => text.contains(typo))){
          twitter.createFavorite(status.getId)
        }
      }
    })
    stream.filter(config.query)
  }

}
