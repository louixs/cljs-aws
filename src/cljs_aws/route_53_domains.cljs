(ns cljs-aws.route-53-domains
  (:require [cljs-aws.requests])
  (:require-macros [cljs-aws.service :refer [defservice]]))

(defservice "Route53Domains" "route53domains-2014-05-15.min.json")
