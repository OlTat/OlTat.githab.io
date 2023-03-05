package com.example.homework13and14;

import java.util.Date;

public class UrlStatDTO extends UrlResultDTO {
    private long redirects;
    private Date lastAccess; // TODO: set normal format

    public long getRedirects() {
        return redirects;
    }

    public void setRedirects(long redirects) {
        this.redirects = redirects;
    }

    public Date getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Date lastAccess) {
        this.lastAccess = lastAccess;
    }
}
