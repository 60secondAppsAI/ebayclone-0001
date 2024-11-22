import Vue from "vue";
import VueRouter from "vue-router";
import DefaultLayout from "@/layouts/DefaultLayout.vue";
import Users from  '@/pages/Users.vue';
import UserDetail from  '@/pages/UserDetail.vue';
import Products from  '@/pages/Products.vue';
import ProductDetail from  '@/pages/ProductDetail.vue';
import Categorys from  '@/pages/Categorys.vue';
import CategoryDetail from  '@/pages/CategoryDetail.vue';
import Orders from  '@/pages/Orders.vue';
import OrderDetail from  '@/pages/OrderDetail.vue';
import OrderItems from  '@/pages/OrderItems.vue';
import OrderItemDetail from  '@/pages/OrderItemDetail.vue';
import Reviews from  '@/pages/Reviews.vue';
import ReviewDetail from  '@/pages/ReviewDetail.vue';
import Biddings from  '@/pages/Biddings.vue';
import BiddingDetail from  '@/pages/BiddingDetail.vue';
import Auctions from  '@/pages/Auctions.vue';
import AuctionDetail from  '@/pages/AuctionDetail.vue';
import Payments from  '@/pages/Payments.vue';
import PaymentDetail from  '@/pages/PaymentDetail.vue';
import Carts from  '@/pages/Carts.vue';
import CartDetail from  '@/pages/CartDetail.vue';
import CartItems from  '@/pages/CartItems.vue';
import CartItemDetail from  '@/pages/CartItemDetail.vue';
import Wishlists from  '@/pages/Wishlists.vue';
import WishlistDetail from  '@/pages/WishlistDetail.vue';
import WishlistItems from  '@/pages/WishlistItems.vue';
import WishlistItemDetail from  '@/pages/WishlistItemDetail.vue';
import Sellers from  '@/pages/Sellers.vue';
import SellerDetail from  '@/pages/SellerDetail.vue';
import Feedbacks from  '@/pages/Feedbacks.vue';
import FeedbackDetail from  '@/pages/FeedbackDetail.vue';
import Addresss from  '@/pages/Addresss.vue';
import AddressDetail from  '@/pages/AddressDetail.vue';
import PaymentMethods from  '@/pages/PaymentMethods.vue';
import PaymentMethodDetail from  '@/pages/PaymentMethodDetail.vue';
import Shipments from  '@/pages/Shipments.vue';
import ShipmentDetail from  '@/pages/ShipmentDetail.vue';
import Notifications from  '@/pages/Notifications.vue';
import NotificationDetail from  '@/pages/NotificationDetail.vue';
import Reports from  '@/pages/Reports.vue';
import ReportDetail from  '@/pages/ReportDetail.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: () => import("../views/HomeView.vue"),
			redirect: '/users',
																				  },
  {
    path: "/pricing",
    name: "PricingView",
    component: () => import("../views/PricingView.vue"),
  },
  {
    path: "/arts-gallery",
    name: "ArtsGalleryView",
    component: () => import("../views/ArtsGalleryView.vue"),
  },
  {
    path: "/checkout/:id",
    name: "CheckoutView",
    component: () => import("../views/CheckoutView.vue"),
  },
  {
    path: "/stripe-checkout",
    name: "StripeCheckoutView",
    component: () => import("../views/StripeCheckoutView.vue"),
  },
	{
		path: '/users',
		name: 'Users',
		layout: DefaultLayout,
		component: Users,
	},
	{
	    path: '/user/:userId', 
	    name: 'UserDetail',
		layout: DefaultLayout,
	    component: UserDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/products',
		name: 'Products',
		layout: DefaultLayout,
		component: Products,
	},
	{
	    path: '/product/:productId', 
	    name: 'ProductDetail',
		layout: DefaultLayout,
	    component: ProductDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/categorys',
		name: 'Categorys',
		layout: DefaultLayout,
		component: Categorys,
	},
	{
	    path: '/category/:categoryId', 
	    name: 'CategoryDetail',
		layout: DefaultLayout,
	    component: CategoryDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orders',
		name: 'Orders',
		layout: DefaultLayout,
		component: Orders,
	},
	{
	    path: '/order/:orderId', 
	    name: 'OrderDetail',
		layout: DefaultLayout,
	    component: OrderDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/orderItems',
		name: 'OrderItems',
		layout: DefaultLayout,
		component: OrderItems,
	},
	{
	    path: '/orderItem/:orderItemId', 
	    name: 'OrderItemDetail',
		layout: DefaultLayout,
	    component: OrderItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/reviews',
		name: 'Reviews',
		layout: DefaultLayout,
		component: Reviews,
	},
	{
	    path: '/review/:reviewId', 
	    name: 'ReviewDetail',
		layout: DefaultLayout,
	    component: ReviewDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/biddings',
		name: 'Biddings',
		layout: DefaultLayout,
		component: Biddings,
	},
	{
	    path: '/bidding/:biddingId', 
	    name: 'BiddingDetail',
		layout: DefaultLayout,
	    component: BiddingDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/auctions',
		name: 'Auctions',
		layout: DefaultLayout,
		component: Auctions,
	},
	{
	    path: '/auction/:auctionId', 
	    name: 'AuctionDetail',
		layout: DefaultLayout,
	    component: AuctionDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/payments',
		name: 'Payments',
		layout: DefaultLayout,
		component: Payments,
	},
	{
	    path: '/payment/:paymentId', 
	    name: 'PaymentDetail',
		layout: DefaultLayout,
	    component: PaymentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/carts',
		name: 'Carts',
		layout: DefaultLayout,
		component: Carts,
	},
	{
	    path: '/cart/:cartId', 
	    name: 'CartDetail',
		layout: DefaultLayout,
	    component: CartDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/cartItems',
		name: 'CartItems',
		layout: DefaultLayout,
		component: CartItems,
	},
	{
	    path: '/cartItem/:cartItemId', 
	    name: 'CartItemDetail',
		layout: DefaultLayout,
	    component: CartItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlists',
		name: 'Wishlists',
		layout: DefaultLayout,
		component: Wishlists,
	},
	{
	    path: '/wishlist/:wishlistId', 
	    name: 'WishlistDetail',
		layout: DefaultLayout,
	    component: WishlistDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/wishlistItems',
		name: 'WishlistItems',
		layout: DefaultLayout,
		component: WishlistItems,
	},
	{
	    path: '/wishlistItem/:wishlistItemId', 
	    name: 'WishlistItemDetail',
		layout: DefaultLayout,
	    component: WishlistItemDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/sellers',
		name: 'Sellers',
		layout: DefaultLayout,
		component: Sellers,
	},
	{
	    path: '/seller/:sellerId', 
	    name: 'SellerDetail',
		layout: DefaultLayout,
	    component: SellerDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/feedbacks',
		name: 'Feedbacks',
		layout: DefaultLayout,
		component: Feedbacks,
	},
	{
	    path: '/feedback/:feedbackId', 
	    name: 'FeedbackDetail',
		layout: DefaultLayout,
	    component: FeedbackDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/addresss',
		name: 'Addresss',
		layout: DefaultLayout,
		component: Addresss,
	},
	{
	    path: '/address/:addressId', 
	    name: 'AddressDetail',
		layout: DefaultLayout,
	    component: AddressDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/paymentMethods',
		name: 'PaymentMethods',
		layout: DefaultLayout,
		component: PaymentMethods,
	},
	{
	    path: '/paymentMethod/:paymentMethodId', 
	    name: 'PaymentMethodDetail',
		layout: DefaultLayout,
	    component: PaymentMethodDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/shipments',
		name: 'Shipments',
		layout: DefaultLayout,
		component: Shipments,
	},
	{
	    path: '/shipment/:shipmentId', 
	    name: 'ShipmentDetail',
		layout: DefaultLayout,
	    component: ShipmentDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/notifications',
		name: 'Notifications',
		layout: DefaultLayout,
		component: Notifications,
	},
	{
	    path: '/notification/:notificationId', 
	    name: 'NotificationDetail',
		layout: DefaultLayout,
	    component: NotificationDetail,
	    props: true // Pass route params as props to the component
  	},
	{
		path: '/reports',
		name: 'Reports',
		layout: DefaultLayout,
		component: Reports,
	},
	{
	    path: '/report/:reportId', 
	    name: 'ReportDetail',
		layout: DefaultLayout,
	    component: ReportDetail,
	    props: true // Pass route params as props to the component
  	},
];

const router = new VueRouter({
  mode: "hash",
  base: process.env.BASE_URL,
  routes,
});

export default router;
