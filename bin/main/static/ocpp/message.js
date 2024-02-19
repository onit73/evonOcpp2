export class MessageGenerator{

    authorize(idTag){
        return `[2,\"123\",\"Authorize\",{\"idTag\":\"${idTag}\"}]`;
    }
}

