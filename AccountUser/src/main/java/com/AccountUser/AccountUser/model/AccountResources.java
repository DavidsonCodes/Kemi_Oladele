package com.AccountUser.AccountUser.model;

import org.springframework.hateoas.RepresentationModel;

public class AccountResources extends RepresentationModel<AccountResources> {
    private AccountUser accountUser;

    public AccountUser getAccountUser() {
        return accountUser;
    }

    public void setAccountUser(AccountUser accountUser) {
        this.accountUser = accountUser;
    }
}
