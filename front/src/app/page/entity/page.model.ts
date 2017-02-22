export class Page {

    constructor(private title: string,
                private uri: string) {}


    get getTitle(): string {
        return this.title;
    }

    setTitle(newTitle: string): void {
        this.title = newTitle;
    }

    get getURI(): string {
        return this.uri;
    }

    setURI(newURI: string): void {
        this.uri = newURI;
    }

}