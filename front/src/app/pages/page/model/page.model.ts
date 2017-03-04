export class Page {

    private id : number;
    private title : string;
    private children: Array<Page>;
    private identifier: string;

    constructor(title: string,
                uri: string,
                children?: Array<Page>,
                id?: number) {
        this.id = id;
        this.title = title;
        this.children = children;
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

    get getChildren(): Array<Page> {
        return this.children;
    }

    setChildren(children: Array<Page>): void {
        this.children = children;
    }

}