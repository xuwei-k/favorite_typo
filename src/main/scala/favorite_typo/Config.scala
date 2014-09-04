package favorite_typo

import twitter4j.{TwitterFactory, Twitter, TwitterStream, TwitterStreamFactory}
import twitter4j.conf.ConfigurationBuilder

abstract class Config{
  def twitter: TwitterSettings
  private[this] lazy val twitterConfig = {
    val c = new ConfigurationBuilder
     c.setDebugEnabled(true)
      .setOAuthConsumerKey(twitter.consumerKey)
      .setOAuthConsumerSecret(twitter.consumerSecret)
      .setOAuthAccessToken(twitter.accessToken)
      .setOAuthAccessTokenSecret(twitter.accessTokenSecret)
    c.build
  }
  final def getTwitterStream: TwitterStream =
    new TwitterStreamFactory(twitterConfig).getInstance()
  final def getTwitter: Twitter =
    new TwitterFactory(twitterConfig).getInstance()
  def typoWords: Set[String]
  def query: twitter4j.FilterQuery = new twitter4j.FilterQuery().track(typoWords.toArray)
}

abstract class TwitterSettings{
  val consumerKey: String
  val consumerSecret: String
  val accessToken: String
  val accessTokenSecret: String
}

