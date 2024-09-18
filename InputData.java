package com.shamirsecretsharing;

class InputData {
	 private String secret;
	    private int threshold;
	    private int numShares;

	    public InputData(String secret, int threshold, int numShares) {
	        this.secret = secret;
	        this.threshold = threshold;
	        this.numShares = numShares;
	    }

	    public String getSecret() {
	        return secret;
	    }

	    public int getThreshold() {
	        return threshold;
	    }

	    public int getNumShares() {
	        return numShares;
	    }
}
