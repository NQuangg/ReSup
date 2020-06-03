# Deploying

To deploy your app:
```bash
 mvn clean package appengine:deploy -Dapp.deploy.promote=false -Dapp.deploy.version=VERSION_ID
```

To view your app:
```
gcloud app browse
```

