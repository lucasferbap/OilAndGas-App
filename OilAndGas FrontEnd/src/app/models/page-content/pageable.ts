import { Sort } from './sort';

export class Pageable {
    sort: Sort;
    offset: Number
    pageNumber: Number;
    pageSize: Number;
    paged: Boolean;
    unpaged: Boolean;

    constructor() {
        this.sort = new Sort();
        this.offset = new Number()
        this.pageNumber = new Number();
        this.pageSize = new Number();
        this.paged = new Boolean();
        this.unpaged = new Boolean();
    }
}