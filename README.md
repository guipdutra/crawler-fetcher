# crawler-fetcher

Fetch the repositories from Github to distribute the process for workers([crawler-contrib](https://github.com/guipdutra/crawler-contrib)).

## Setup the workers
Go to [crawler-contrib](https://github.com/guipdutra/crawler-contrib) and run it on your servers that you want to distribute.
On the `distributor.clj#servers` has a list of where workers are running. Add your worker addresses.

Make sure you set the number of repositories you wish to fetch from github before running Crawler-contrib.

You can use `take x` in `github_api_wrapper.clj#get-all-repositories` to load just a few repos. Should you leave it without a limit, it will fetch about 12 million github repos (this could take a long time).

###Example: 
```clojure
(take 10 (repos/all-repos (merge (auth) options)))
```


