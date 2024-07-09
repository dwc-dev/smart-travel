import request from "@/utils/request";

export function getOrderInformation(query) {
  return request({
    url: '/test/ticket_order/information',
    method: 'get',
    params: query
  })
}
