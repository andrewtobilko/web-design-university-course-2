export class Page {

    constructor(private title: string,
                private identifier: string) {}


    get getTitle(): string {
        return this.title;
    }

    setTitle(newTitle: string): void {
        this.title = newTitle;
    }

    get getURI(): string {
        return this.identifier;
    }

    setURI(uri: string): void {
        this.identifier = uri;
    }

}