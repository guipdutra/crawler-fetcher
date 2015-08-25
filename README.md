# crawler-fetcher

Fetch the repositories from Github to distribute the process for workers([crawler-contrib](https://github.com/guipdutra/crawler-contrib)).

## Setup the workers
Go to [crawler-contrib](https://github.com/guipdutra/crawler-contrib) and run it on your servers that you want to distribute.
On the `distributor.clj#servers` has a list of where workers are running. Add your worker addresses.

###Example: 
```clojure
(take 10 (repos/all-repos (merge (auth) options)))
```

## Usage
- Create your personal access token on Github and put it in an env variable named `GITHUB_ACCESS_TOKEN_1`.

- Install Leiningen
- Install the dependencies:
```bash
       $ lein deps
```
- Run tests:
```bash
       $ lein midje
```
- Run crawler-fetcher:
```bash
       $ lein run
```

Make sure you set the number of repositories you wish to fetch from github before running Crawler-fetcher.

You can use `take x` in `github_api_wrapper.clj#get-all-repositories` to load just a few repos. Should you leave it without a limit, it will fetch about 12 million github repos (this could take a long time).
