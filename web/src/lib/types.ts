import { Product } from "./Product";
import { Store } from "./Store";

export type FormType = "producto" | "local";

export type FormState =
    | {
          message?: string;
          data?: Product | Store;
      }
    | undefined;
