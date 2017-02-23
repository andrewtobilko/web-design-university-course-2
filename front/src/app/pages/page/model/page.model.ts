export class Page {

    private title : string;
    private uri : string;

    constructor(title: string,
                uri: string) {
        this.title = title;
        this.uri = uri;
    }

    get getTitle(): string {
        return this.title;
    }

    setTitle(newTitle: string): void {
        this.title = newTitle;
    }

    get getURI(): string {
        return this.uri;
    }

    setURI(uri: string): void {
        this.uri = uri;
    }

    toString = () : string => {
        return 'Title: ' + this.title + ', url: ' + this.uri;
    }

}