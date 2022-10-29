import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "src/environments/environment";

@Injectable({
    providedIn: 'root',
})
export class GroupService {

    url = environment.httpUrl + "/";
    
    constructor(private http: HttpClient) { }

    createGroup(body : string) {
       return this.http.post<{id: string, name: string}>(this.url + "group/create", body);
    }

    addParticipants(groupId: string, participants: string[]) {
        return this.http.post(this.url + "group/addParticipants/" + groupId, participants);     
    }

    getAllGroups(userId: string) {
        return this.http.get<{id: string, name: string}[]>(this.url + "group/all/" + userId);
    }
    
}