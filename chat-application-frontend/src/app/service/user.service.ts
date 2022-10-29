import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, map, Observable, of, Subject } from "rxjs";
import { environment } from "src/environments/environment";
import { User } from "src/models/user.model";

@Injectable({
    providedIn: 'root',
})
export class UserService {

    url = environment.httpUrl;
    currentUserSubject: BehaviorSubject<User> = new BehaviorSubject<User>({id: "", name: ""});
    currentUserObs$ = this.currentUserSubject.asObservable();
    
    constructor(private http: HttpClient) { }

    login(body: {id:string, password:string}) {
        return this.http.put(this.url + "user/login", body);
    }

    saveCurrentUser(userId: string) {
        
        return this.http.get<User>(`${this.url}user/${userId}`).pipe(
            map((resp: User) => {
                localStorage.setItem("userId", userId);
                this.currentUserSubject.next(resp);
            })
        )
        
    }

    getAllUser(): Observable<User[]> {
        return this.http.get<User[]>(this.url + "user/all").pipe(
            map((resp: User[]) => {
                return resp.filter((u) => u.id !== this.currentUserSubject.value.id);
            })
        )
    }

    register(body: {id:string, password:string, name: string}) {
        return this.http.post(this.url + "user/register", body);

    }

    logOut(userId: string) {
        return this.http.put(this.url + "user/logout/" + userId, null).pipe(
            map(() => {
                localStorage.clear();
                this.currentUserSubject.next({id: "", name:""});
            })
        )
        
    }
}