export interface Information {}
export interface History {}
export interface President {}
export interface TeachingStaff {}
export interface Publishing {}

export interface Contact {
    phoneNumbers: [
        {
            id: number;
            contactInfo: string;
            number: string;
        }
    ];
    addresses: [
        {
            id: number;
            cityName: string;
            streetName: string;
            number: string;
            postalCode: string;
        }
    ];
    location: {
        id: number;
        longitude: number;
        latitude: number;
        name: string;
    };
}
