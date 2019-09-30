package com.api.apitester;

/**
 * Created by sr250345 on 2/7/17.
 */
public class RequestData {

    private String method;
    private String url;
    private String payload;
    private String statuscode;
    private String statusline;
    private String responsebody;
    private String headers;
    
	public RequestData()
    {

    }
	
    public RequestData(String method, String url, String payload,String headers, String statuscode, String statusline,
			String responsebody) {
		super();
		this.method = method;
		this.url = url;
		this.payload = payload;
		this.statuscode = statuscode;
		this.statusline = statusline;
		this.responsebody = responsebody;
		this.headers = headers;
		
	}

	
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }


    public String getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
	public String getStatusline() {
		return statusline;
	}
	public void setStatusline(String statusline) {
		this.statusline = statusline;
	}
	public String getResponsebody() {
		return responsebody;
	}
	public void setResponsebody(String responsebody) {
		this.responsebody = responsebody;
	}

	/**
	 * @return the headers
	 */
	public String getHeaders() {
		return headers;
	}

	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	
}
