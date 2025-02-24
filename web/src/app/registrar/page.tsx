import Selectors from "./ui/Selectors";
import Form from "./ui/Form";
import { FormType } from "@/lib/types";

export default async function RegisterPage({
    searchParams,
}: {
    searchParams: Promise<{ type: FormType }>;
}) {
    const type = (await searchParams).type;
    const registrationType = type ? type : "producto";
    return (
        <div className="h-full p-10 grid grid-cols-[20%_80%]">
            <div className="flex flex-col items-center justify-center gap-10">
                <Selectors />
            </div>
            <div className="h-full grid place-content-center grid-cols-[40%]">
                <Form type={registrationType} />
            </div>
        </div>
    );
}
