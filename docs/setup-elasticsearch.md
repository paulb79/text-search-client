# Install va homebrew

If you don't have homebrew installed -  [get homebrew here](http://brew.sh/)

Then run:  `brew install elasticsearch`

# Configuration

Update the elasticsearch configuration file in ` /usr/local/etc/elasticsearch/elasticsearch.yml`. 

Set the value below to false:

    discovery.zen.ping.multicast.enabled: false #(it's true by default)

# How to start it

Other sources say to use a removed `brew services` command. You get it via `brew tap gapple/services`. Then you're supposed to run `brew services start <package-to-start>`.

If brew `services start elasticsearch` doesn't work for you, check the instructions when you run `brew info elasticsearch`. 

Mine says:

    To have launchd start elasticsearch at login:
      ln -sfv /usr/local/opt/elasticsearch/*.plist ~/Library/LaunchAgents
    Then to load elasticsearch now:
      launchctl load ~/Library/LaunchAgents/homebrew.mxcl.elasticsearch.plist
    Or, if you don't want/need launchctl, you can just run:
      elasticsearch --config=/usr/local/opt/elasticsearch/config/elasticsearch.yml
  
# Sources

- [Quick Elasticsearch / Kibana / Logstash (ELK stack) Install (for your local mac dev box) - gist.github.com](https://gist.github.com/squarism/8fa9cdd7d6b36c9fcb45)
- [Important Configuration Changes - www.elastic.co](https://www.elastic.co/guide/en/elasticsearch/guide/current/_important_configuration_changes.html#_prefer_unicast_over_multicast)