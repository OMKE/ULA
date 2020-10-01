export interface Faculty {
    id: number;
    name: string;
    campusId?: number;
    icon: string;
    contact?: {
        address?: {
            id: number;
            cityId: number;
            cityName: string;
            streetName: string;
            number: string;
            postalCode: string;
            country: string;
        };
        phoneNumber: string;
        email: string;
    };
    location?: {
        id: number;
        longitude: number;
        latitude: number;
        name: string;
    };
    information?: {
        facultyId: number;
        history: string;
        president: string;
        mission: string;
        accreditation: string;
    };
}
