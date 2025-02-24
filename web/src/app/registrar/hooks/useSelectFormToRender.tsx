import { registerProduct } from "@/api/Product";
import { registerStore } from "@/api/Store";
import { FormState, FormType } from "@/lib/types";
import StoreInputs from "../ui/StoreInputs";
import ProductInputs from "../ui/ProductInputs";

type FormToRender = {
    formAction: (state: FormState, formData: FormData) => Promise<FormState>;
    component: React.ReactNode;
};

export default function useSelectFormToRender(type: FormType): FormToRender {
    switch (type) {
        case "local":
            return { formAction: registerStore, component: <StoreInputs /> };
        case "producto":
            return {
                formAction: registerProduct,
                component: <ProductInputs />,
            };
    }
}
