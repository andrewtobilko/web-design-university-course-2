export class Page {

    private id : number;
    private title : string;
    private identifier : string;

    constructor(title: string,
                uri: string,
                id?: number) {
        this.id = id;
        this.title = title;
        this.identifier = uri;
    }

    get getId(): number {
        return this.id;
    }

    get getTitle(): string {
        return this.title;
    }

    setTitle(newTitle: string): void {
        this.title = newTitle;
    }

    get getIdentifier(): string {
        return this.identifier;
    }

    setIdentifier(uri: string): void {
        this.identifier = uri;
    }

    toString = () : string => {
        return 'Title: ' + this.title + ', url: ' + this.identifier;
    }

}