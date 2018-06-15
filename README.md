# Example of Development Camel in Fuse

### Environments

* Red hat fuse 7
* Red hat AMQ 7
* Apache Camel

**Note: setting.xml is the maven setting that places in the ".m" folder. It configured the Repository when developing with Fuse

### Install features for AMQ
Fuse doesn't support AMQ out-of-box but you just need to install a few features as following 

```
feature:install jms
feature:install activemq-client
feature:install camel-activemq
```

Add feature-repo if needed
```feature:repo-add mvn:org.fusesource/activemq-karaf/7.0.0.fuse-000211-redhat-1/xml/features```
