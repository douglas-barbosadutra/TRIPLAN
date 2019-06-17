import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IUser } from 'app/shared/model/AdminMicroservices/user.model';
import { Principal } from 'app/core';
import { UserService } from './user.service';

@Component({
    selector: 'jhi-user',
    templateUrl: './user.component.html'
})
export class UserComponent implements OnInit, OnDestroy {
    users: IUser[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        private userService: UserService,
        private jhiAlertService: JhiAlertService,
        private eventManager: JhiEventManager,
        private principal: Principal
    ) {}

    loadAll() {
        this.userService.query().subscribe(
            (res: HttpResponse<IUser[]>) => {
                this.users = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.principal.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInUsers();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IUser) {
        return item.id;
    }

    registerChangeInUsers() {
        this.eventSubscriber = this.eventManager.subscribe('userListModification', response => this.loadAll());
    }

    private onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
