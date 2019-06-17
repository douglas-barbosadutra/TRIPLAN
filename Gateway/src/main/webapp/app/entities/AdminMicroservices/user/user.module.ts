import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { GatewaySharedModule } from 'app/shared';
import {
    UserComponent,
    UserDetailComponent,
    UserUpdateComponent,
    UserDeletePopupComponent,
    UserDeleteDialogComponent,
    userRoute,
    userPopupRoute
} from './';

const ENTITY_STATES = [...userRoute, ...userPopupRoute];

@NgModule({
    imports: [GatewaySharedModule, RouterModule.forChild(ENTITY_STATES)],
    declarations: [UserComponent, UserDetailComponent, UserUpdateComponent, UserDeleteDialogComponent, UserDeletePopupComponent],
    entryComponents: [UserComponent, UserUpdateComponent, UserDeleteDialogComponent, UserDeletePopupComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayUserModule {}
