import favorite_typo._

new Config {

  override def twitter = new TwitterSettings{
    val consumerKey:String       = ""
    val consumerSecret:String    = ""
    val accessToken:String       = ""
    val accessTokenSecret:String = ""
  }

  override def typoWords = Set("ScalaMaturi", "scalamaturi")
}

